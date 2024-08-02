package com.xuhh.foundation.jdkProxy;

import com.xuhh.foundation.jdkProxy.JdkInvocationHandler;
import com.xuhh.foundation.jdkProxy.ProductService;
import com.xuhh.foundation.jdkProxy.ProductServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception {
        ProductService productService = new ProductServiceImpl();
        ProductService proxy = (ProductService) new JdkInvocationHandler().getInstance(productService);
        proxy.addProduct("iphone");

        // 这里我们将jdk生成的代理类输出了出来，方便后面分析使用
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{productService.getClass()});

        FileOutputStream os = new FileOutputStream("Proxy0.class");
        os.write(bytes);
        os.close();
    }
}
