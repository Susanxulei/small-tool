# Context Inconsistency Checking Tool
## 1. Configuration
###  create a file named **config.properties**
```
#描述rule的xml文件路径
ruleFilePath=consistency_rules.xml
#描述pattern的xml文件路径
patternFilePath=consistency_patterns.xml
#描述context的txt文件路径
dataFilePath=data/00_small_change.txt
#指定输出log的路径
logFilePath=PCC_00_small.log
#算法选择（目前可选项是ECC、PCC、Con-C）
technique=PCC
#描述类型
changeHandlerType=static-time-based
#描述几个context change触发一次check（即batch值，可选项是正整数或是GEAS）
schedule=1
#Con-C算法启动的线程数
taskNum=4

```

## 2. Run
### (1) Clone [this repository](https://github.com/njucjc/small-tool/).
```
$ git clone https://github.com/njucjc/small-tool.git
```
### (2) Import this project with **IntelliJ IDEA**.
### (3) Build this project.
### (4) Start to run it with **IDEA**.

## 3. Reference
### (1) Xu, Chang, Shing-Chi Cheung, and Wing-Kwong Chan. "Incremental consistency checking for pervasive context." Proceedings of the 28th international conference on Software engineering. ACM, 2006.
### (2) Xu, Chang, et al. "Towards context consistency by concurrent checking for internetware applications." Science China Information Sciences 56.8 (2013): 1-20.
