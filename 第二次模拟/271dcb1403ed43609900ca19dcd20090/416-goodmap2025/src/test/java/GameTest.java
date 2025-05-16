/**
 *  Created by lujxu on 2017/12/10.
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    String lineBreak;

    Game game;
    String initInfo;
    String steps;

    @Before
    public void setUp() {
        lineBreak=System.getProperty( "line.separator" );
        console = System.out;
        bytes = new ByteArrayOutputStream();
        // System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() {
        // System.setOut(console);
    }

    @Test
    public void testGameCaseOne() {
        initInfo = "4;1,1,false;2,2,true";
        steps = "R,L,D,L";
        game = new Game(initInfo);
        assertEquals(2, game.playGame(steps));
        System.out.println(game.getMap().print());
        System.out.println("!!!!!!!!!!");
        System.out.println("- - - -"+lineBreak+"- - - -"+lineBreak+"y - X -"+lineBreak+"- - - -");
        assertEquals("- - - -"+lineBreak+"- - - -"+lineBreak+"y - X -"+lineBreak+"- - - -", game.getMap().print());
        // assertTrue(game.playGame(steps)==2);
        // assertTrue(("- - - -"+lineBreak+"- - - -"+lineBreak+"y - X -"+lineBreak+"- - - -"+lineBreak+Result.DRAW+lineBreak).equals(bytes.toString()));
    }

    @Test
    public void testGameCaseOneResult() {
        initInfo = "4;1,1,false;2,2,true";
        steps = "R,L,D,L";
        game = new Game(initInfo);
        assertEquals(2, game.playGame(steps));
        assertEquals(Result.DRAW, game.getMap().resultEvaluation());
        // assertTrue(game.playGame(steps)==2);
        // assertTrue(("- - - -"+lineBreak+"- - - -"+lineBreak+"y - X -"+lineBreak+"- - - -"+lineBreak+Result.DRAW+lineBreak).equals(bytes.toString()));
    }
    @Test
    public void testGameCaseTwo() {
        initInfo = "6;0,1,true;4,4,true";
        steps = "R,U,D,R,L,D";
        game = new Game(initInfo);
        assertEquals(5, game.playGame(steps));
        assertEquals("- - - - - -"+lineBreak+"- x - - - -"+lineBreak+"- - - - - -"+lineBreak+"- - - - - -"+lineBreak+"- - - - - y"+lineBreak+"- - - - - -", game.getMap().print());
        // assertTrue(game.playGame(steps)==5);
        // assertTrue(("- - - - - -"+lineBreak+"- x - - - -"+lineBreak+"- - - - - -"+lineBreak+"- - - - - -"+lineBreak+"- - - - - y"+lineBreak+"- - - - - -"+lineBreak+Result.DRAW+lineBreak).equals(bytes.toString()));
    }

    @Test
    public void testGameCaseTwoResult() {
        initInfo = "6;0,1,true;4,4,true";
        steps = "R,U,D,R,L,D";
        game = new Game(initInfo);
        assertEquals(5, game.playGame(steps));
        assertEquals(Result.DRAW, game.getMap().resultEvaluation());
        // assertTrue(game.playGame(steps)==5);
        // assertTrue(("- - - - - -"+lineBreak+"- x - - - -"+lineBreak+"- - - - - -"+lineBreak+"- - - - - -"+lineBreak+"- - - - - y"+lineBreak+"- - - - - -"+lineBreak+Result.DRAW+lineBreak).equals(bytes.toString()));
    }

    @Test
    public void testGameCaseThree() {
        initInfo = "9;3,2,false;8,8,false";
        steps = "R,L,U,U";
        game = new Game(initInfo);
        assertEquals(6, game.playGame(steps));
        assertEquals("- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - X - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - Y -"+lineBreak+"- - - - - - - - -", game.getMap().print());

        // assertTrue(game.playGame(steps)==6);
        // assertTrue(("- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - X - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - Y -"+lineBreak+"- - - - - - - - -"+lineBreak+Result.DRAW+lineBreak).equals(bytes.toString()));
    }

    @Test
    public void testGameCaseThreeResult() {
        initInfo = "9;3,2,false;8,8,false";
        steps = "R,L,U,U";
        game = new Game(initInfo);
        assertEquals(6, game.playGame(steps));
        assertEquals(Result.DRAW, game.getMap().resultEvaluation());

        // assertTrue(game.playGame(steps)==6);
        // assertTrue(("- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - X - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - - -"+lineBreak+"- - - - - - - Y -"+lineBreak+"- - - - - - - - -"+lineBreak+Result.DRAW+lineBreak).equals(bytes.toString()));
    }
}


