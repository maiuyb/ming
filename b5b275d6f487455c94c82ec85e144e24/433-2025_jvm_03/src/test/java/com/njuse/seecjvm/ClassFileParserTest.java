package com.njuse.seecjvm;

import com.njuse.seecjvm.classloader.classfileparser.ClassFile;
import com.njuse.seecjvm.classloader.classfilereader.ClassFileReader;
import com.njuse.seecjvm.memory.jclass.Field;
import com.njuse.seecjvm.memory.jclass.JClass;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ClassFileParserTest {
    public static final String TEST_JAR_PATH = String.join(File.separator,"src","test","testjar");
    public static ClassFileReader classFileReader = ClassFileReader.getInstance();

    @Before
    public void setPath(){
        ClassFileReader.setUserClasspath(TEST_JAR_PATH);
    }

    @Test
    public void parseObjectClass(){
        String className = "LocalObject";
        byte[] content=null;
        ClassFile classfile=null;

        try {
            content = classFileReader.readClassFile(className,null).getKey();
            assert  content!=null;
            classfile = new ClassFile(content);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert classfile!=null;
        assertEquals(51,classfile.getThisClass());
        assertEquals(0, classfile.getSuperClass());
        assertEquals(0, classfile.getInterfacesCount());
        assertEquals("java/lang/Object", classfile.getClassName());

        //construct JClass
        JClass clazz = new JClass(classfile);
        //method name
        String[] expectedMethods = getExpectMethods(className);
        List<String> realMethods = Arrays.stream(clazz.getMethods())
                .map(m->m.getDescriptor()+" "+m.getName()+" "+m.getArgc()+" "+m.getMaxLocal()+" "+m.getMaxStack()).collect(Collectors.toList());
        for (String m:expectedMethods){
            assertTrue(realMethods.contains(m));
        }
    }

    public String[] getExpectMethods(String className){
        String filePath = String.join(File.separator,"src","test","testInfo",className+".txt");
        File file = new File(filePath);
        String[] ret=null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String res = reader.readLine();
            ret = res.split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
