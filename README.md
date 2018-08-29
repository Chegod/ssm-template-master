# ssm-template-master
这个项目使用Gradle管理，整合了SpringMVC、Spring、Mybatis框架。

## Gradle简介

Gradle是继Maven之后的新一代构建工具，它采用基于groovy的DSL语言作为脚本，相比传统构建工具通过XML来配置而言，最直观上的感受就是脚本更加的简洁、优雅。

## 项目结构说明

### ssm-template-master 根项目

一个根模块项目下有多个子模块项目，根项目下的build.gradle文件可以对一些公共属性、插件、依赖等进行统一配置。

### settings.gradle 文件

多模块项目需要有一个根模块项目以及模块描述文件(默认为settings.gradle)。

### gradle.properties 文件

根项目下有一个gradle.properties文件，专门用来配置全局键值对数据的，Gradle会自动加载，可用${key}获取值。

### dependencies.gradle 文件

在根项目下创建dependencies.gradle，用于同一管理版本号和jar包：

```
ext {
    versions = [
            //spring
            spring_version                  : '5.0.5.RELEASE',
            aopalliance_version             : '1.0',
            aspectjweaver_version           : '1.9.0',
    ]
    
    def ver = rootProject.ext.versions
    libraries = [
            //spring
            "spring-expression"       : "org.springframework:spring-expression: ${ver.spring_version}",
            "aopalliance"             : "aopalliance:aopalliance:${ver.aopalliance_version}",
            "aspectjweaver"           : "org.aspectj:aspectjweaver: ${ver.aspectjweaver_version}",
    ]
}
```
然后在根项目的 build.gradle 中引入：
```
apply from: 'dependencies.gradle'
```
这样就可以在根项目和子项目中引入jar包：
```
def libs = rootProject.ext.libraries
dependencies {
        compile(
                libs["spring-expression"],
                libs["aopalliance"],
                libs["aspectjweaver"],
        )
    }
```

## Gradle常用配置

### 中文编码问题

解决警告：编码 GBK 的不可映射字符
```
[compileJava, compileTestJava]*.options*.encoding = 'UTF-8'
```
### mavenCentral()中没有的jar包
在根项目中创建一个 libs 文件夹，在build.gradle中引入：
```
dependencies {
    compile(
            //fileTree(dir:"${rootProject.projectDir}/libs",include:['fastdfs-client-java-1.27-SNAPSHOT.jar'])
            fileTree(dir: "${rootProject.projectDir}/libs", include: '*.jar')
    )
}

```

### Mybatis的*Mapper.xml文件被忽略

SourceSets可用于指定不同的项目结构。
Gradle默认会把src/main/resources下的所有配置文件以及src/main/java下的所有java文件打包或发布到classes下面，
但是如果在src/main/java下面也放置一些配置文件,这些配置文件是被忽略的.
```
sourceSets {
    main {
        /*java {
            srcDir 'src/java'
        }*/
        resources {
            srcDir 'src/main/java' //将java目录也设置为资源目录
            srcDir 'src/main/resources' //资源目录
        }
    }
}

```

### 使用logback日志代替 commons-logging 和 log4j 

日志处理
slf4j ：如jdbc一样，定义了一套接口，是一个日志门面，可实现多个日志系统间快速切换
logback ：和log4j是同一作者，是log4j的升级版
logback主要分为三个模块，分别是：logback-core,logback-classic,logback-access*/
```
//配置所有子模块行为
subprojects {
    dependencies {
        compile(
                libs["slf4j-api"],
                libs["jcl-over-slf4j"],//commons-logging切换到slf4j
                libs["log4j-over-slf4j"],//log4j1切换到slf4j
                libs["logback-core"],//提供基础功能，是其他两个模块的基础
                libs["logback-classic"],//log4j的升级，实现了self4j api
                libs["logback-access"],//用于与sevlet容器进行集成、提供网络访问日志的功能
                //libs["logback-ext-spring"],//logback整合springMVC
        )
    }
    //在整个构建过程中排除org.slf4j:slf4j-log4j12、log4j:log4j和commons-logging
    configurations {
        //编译期排除ssm-common模块
        //compile.exclude module: 'ssm-common'
        all*.exclude group: 'commons-logging', module: 'commons-logging'
        all*.exclude group: 'org.slf4j', module: 'slf4j-log4j12'
        all*.exclude group: "log4j", module: "log4j"
        //5.0.4的spring需要使用JMS 2.0版本，而5.7.0activemq-core会导入JMS 1.1的依赖,
        all*.exclude group: "org.apache.geronimo.specs", module: "geronimo-jms_1.1_spec"
    }
}

```
