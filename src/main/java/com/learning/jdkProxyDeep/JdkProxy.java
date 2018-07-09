package com.learning.jdkProxyDeep;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class JdkProxy {

	/**
	 * 动态代理的实现思路: 通过Proxy类的newProxyInstance静态方法返回一个代理对象
	 * 
	 * 1. 声明一段源码（动态产生代理类）
	 * 
	 * 2. 编译该段源码（JDK Compiler API），产生代理类
	 * 
	 * 3. 将代理类load到内存中，产生一个代理对象
	 * 
	 * 4. return 代理对象
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object newProxyInstance(Class<?> interfc, InvocationHdl handler) throws Exception {

		String rt = "\r\n";

		String methodStr = "";
		for (Method m : interfc.getMethods()) {
			methodStr += "	public void " + m.getName() + " () {" + rt + "        try{" + rt
					+ "            Method method = " + interfc.getName() + ".class.getMethod(\"" + m.getName() + "\");"
					+ rt + "            handler.invoke(this, method);" + rt + "        }catch(Exception e){}" + rt
					+ "    }" + rt;
		}

		String srcCode = "package com.kelly.junit;" + rt + "import com.kelly.jdkProxyDeep.InvocationHdl;" + rt
				+ "import java.lang.reflect.Method;" + rt + "public class $Proxy implements " + interfc.getName() + " {"
				+ rt + "	public $Proxy (InvocationHdl handler) {" + rt + "		super();" + rt
				+ "		this.handler = handler;" + rt + "	}" + rt + "	private InvocationHdl handler;" + rt + methodStr
				+ rt + "}";

		// 生成java文件
		String filePath = System.getProperty("user.dir") + "/src/test/java/com/kelly/junit/$Proxy.java";
		System.out.println(filePath);
		File file = new File(filePath);
		FileUtils.writeStringToFile(file, srcCode);

		// 编译java文件，生成class文件
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); // 获取编译器
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null); // 获取文件管理器
		Iterable units = fileManager.getJavaFileObjects(filePath); // 获取文件
		CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units); // 获取编译任务
		task.call(); // 进行编译
		fileManager.close(); // 关闭文件管理器

		// load到内存
		ClassLoader loader = ClassLoader.getSystemClassLoader(); // 获取类加载器
		Class clazz = loader.loadClass("com.kelly.jdkProxyDeep.$Proxy"); // 加载代理类
		System.out.println(clazz.getName());

		// 使用构造器创建对象
		Constructor constructor = clazz.getConstructor(InvocationHdl.class); // 获取构造器
		return constructor.newInstance(handler); // 获取代理对象
	}
}
