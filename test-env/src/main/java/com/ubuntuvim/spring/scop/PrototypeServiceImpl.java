package com.ubuntuvim.spring.scop;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
/**
 * 设置之后，注入到一个单例对象中每次都是一个新的实例。比如下面的使用方式，每次拿到的prototypeService都是一个新的实例对象
 * @Resource
 * PrototypeServiceImpl prototypeService;
  */
@Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeServiceImpl {

}
