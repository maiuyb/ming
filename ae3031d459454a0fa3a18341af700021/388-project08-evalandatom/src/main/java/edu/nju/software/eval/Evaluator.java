package edu.nju.software.eval;

import edu.nju.software.ast.*;
import edu.nju.software.stream.CharLookaheadStream;
import edu.nju.software.token.Lexer;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Evaluator {
    private static final Environment GLOBALS = new Environment();
    private static final LSymbol SYMBOL_LET = new LSymbol("let");
    private static final LSymbol SYMBOL_LET_STAR = new LSymbol("let*");

    private static final LSymbol SYMBOL_DO = new LSymbol("do");
    private static final LSymbol SYMBOL_IF = new LSymbol("if");
    private static final LSymbol SYMBOL_FN_STAR = new LSymbol("fn*");

    private static final LSymbol SYMBOL_DEF = new LSymbol("def");

    static {
        GLOBALS.define(new LSymbol("+"), new LFunction(
                list -> new LInteger(((LInteger) list.content.get(1)).value + ((LInteger) list.content.get(2)).value)));
        GLOBALS.define(new LSymbol("-"), new LFunction(
                list -> new LInteger(((LInteger) list.content.get(1)).value - ((LInteger) list.content.get(2)).value)));
        GLOBALS.define(new LSymbol("*"), new LFunction(
                list -> new LInteger(((LInteger) list.content.get(1)).value * ((LInteger) list.content.get(2)).value)));
        GLOBALS.define(new LSymbol("/"), new LFunction(
                list -> new LInteger(((LInteger) list.content.get(1)).value / ((LInteger) list.content.get(2)).value)));
        GLOBALS.define(new LSymbol("nil"), new LList());
        GLOBALS.define(new LSymbol("cons"), new LFunction(list -> {
            LObject toAdd = list.content.get(1);
            ArrayList<LObject> newList = new ArrayList<>();
            newList.add(toAdd);
            newList.addAll(((LList) list.content.get(2)).content);
            return new LList(newList);
        }));

        // TODO: Your code here
        
    }

    private static LObject handleLetStar(LList list, Environment env) {
        final LList bindings = (LList) list.content.get(1);
        for (LObject bindingObj : bindings.content) {
            LList binding = (LList) bindingObj;
            LObject o = eval(binding.content.get(1), env);
            env.define((LSymbol) binding.content.get(0), o);
        }
        return list.content.get(2);
    }

    private static LObject handleLet(LList list, Environment env) {
        final LList bindings = (LList) list.content.get(1);
        final Environment newEnv = new Environment(env);
        for (LObject bindingObj : bindings.content) {
            LList binding = (LList) bindingObj;
            LObject o = eval(binding.content.get(1), env);
            newEnv.define((LSymbol) binding.content.get(0), o);
        }
        return eval(list.content.get(2), newEnv);
    }


    private static LObject handleDo(LList list, Environment env) {
        for (int i = 1; i < list.content.size() - 1; ++i) {
            eval(list.content.get(i), env);
        }
        return list.content.get(list.content.size() - 1);
    }

    private static LObject handleIF(LList list, Environment env) {
        final LObject condition = eval(list.content.get(1), env);
        if (condition.equals(new LList()) || condition.equals(new LInteger(0))) {
            return list.content.get(3);
        } else {
            return list.content.get(2);
        }
    }

    private static LFunctionTco handleFnStar(LList list, Environment env) {
        final LList a1f = (LList) list.content.get(1);
        final LObject a2f = list.content.get(2);
        Environment e = env.deepClone();
        return new LFunctionTco(a1f, a2f, e);
    }

    private static LObject eval(LObject obj, Environment env) {
        while (true) {
            if (obj instanceof LSymbol) return env.lookup((LSymbol) obj);
            else if (obj instanceof LList) {
                LList list = (LList) obj;
                if (list.content.isEmpty()) {
                    return obj;
                } else if (SYMBOL_DEF.equals(list.content.get(0))) {
                    LSymbol a1 = (LSymbol) list.content.get(1);
                    LFunctionTco res = new LFunctionTco(list.content.get(2), list.content.get(3),
                            new Environment(GLOBALS));
                    env.define(a1, res);
                    res.getEnv().define(a1, res);
                    return res;
                } else if (SYMBOL_LET.equals(list.content.get(0))) {
                    return handleLet(list, env);
                } else if (SYMBOL_LET_STAR.equals(list.content.get(0))) {
                    obj = handleLetStar(list, env);
                } else if (SYMBOL_DO.equals(list.content.get(0))) {
                    obj = handleDo(list, env);
                } else if (SYMBOL_IF.equals(list.content.get(0))) {
                    obj = handleIF(list, env);
                } else if (SYMBOL_FN_STAR.equals(list.content.get(0))) {
                    return handleFnStar(list, env);
                } else {
                    if (!(eval(list.content.get(0), env) instanceof LFunctionTco)) {
                        Environment finalEnv = env;
                        LList evaluated = new LList(
                                list.content.stream().map(o -> eval(o, finalEnv)).collect(Collectors.toList()));
                        return ((LFunction) evaluated.content.get(0)).call(evaluated);
                    }
                    LFunctionTco f = (LFunctionTco) eval(list.content.get(0), env);
                    Environment finalEnv1 = env;
                    LList evaluated = new LList(
                            list.content.stream().map(o -> eval(o, finalEnv1)).collect(Collectors.toList()));
                    obj = f.getAst();
                    env = f.genEnv(evaluated);
                }
            } else {
                return obj;
            }
        }
    }

    public static LObject eval(LObject obj) {
        return eval(obj, GLOBALS);
    }

    public static void main(String[] args) {
        LObject o = Evaluator.eval(
                Parser.parse(Lexer.lex(new CharLookaheadStream("(do (def f (x) (if x (+ x (f (- x 1))) 0)) (f 3) )"))));
        System.out.println(o);
    }
}