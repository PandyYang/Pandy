//package com.pandy.java.obj2map
//
//import com.google.common.collect.Maps
//import org.springframework.cglib.beans.BeanMap
//
//
//fun main() {
//    val staff = Staff("李四", "工人")
//    val person = Person("张三", 1, staff)
//    val beanMap = BeanMap.create(person)
////    for (key in beanMap.keys) {
////        map.put(key as String?, beanMap.get(key))
////    }
//    val map = obj2Map(person)
//    println(checkCon(map))
//}
//
//fun <T>obj2Map(obj: T): Map<String, Any> {
//    val map = Maps.newHashMap<String, Any>()
//    val objMap = BeanMap.create(obj)
//    objMap.keys.forEach { map[it as String?] = objMap[it] }
//    return map
//}
//
//fun checkCon(map: Map<String, Any>): Boolean {
//    return map.none { (_, u) ->
//        when(u) {
//            is String -> {
//                u.isBlank()
//            }
//            is Staff -> {
//                u.name.isEmpty()
//            }
//            is Int -> {
//                u < 0
//            }
//            else -> {
//                false
//            }
//        }
//    }
//}
