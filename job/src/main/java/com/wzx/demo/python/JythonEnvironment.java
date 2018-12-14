package com.wzx.demo.python;

import org.python.util.PythonInterpreter;

import java.util.Properties;

/**
 * @author YM10174
 * @date 2018/12/12 17:31:24
 */
public class JythonEnvironment {
    /**定义一个静态变量**/
    private static JythonEnvironment INSTANCE = new JythonEnvironment();

    /**
     * 私有构造方法
     */
    private JythonEnvironment() {
    }

    /**
     * 获取单例
     *
     * @return JythonEnvironment
     */
    public static JythonEnvironment getInstance() {
        return INSTANCE;
    }

    /**
     * 获取python解释器
     *
     * @return PythonInterpreter
     */
    public PythonInterpreter getPythonInterpreter() {
        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");

        Properties preprops = System.getProperties();
        //对 python 进行初始化
        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter inter = new PythonInterpreter();
        return inter;
    }

}
