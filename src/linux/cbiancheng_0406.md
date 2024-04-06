# L7 Shell 命令的选项和参数在本质上是什么？

* 不管是内件还是外部程序， 就是代码main 方法的入参。
* shell脚本很多是c语言所编写。

# L8 修改提示符
Shell 通过 PS1 和 PS2 这两个环境变量来控制提示符的格式，修改 PS1 和 PS2 的值就能修改命令提示符的格式。
* PS1 控制最外层的命令提示符格式。
* PS2 控制第二层的命令提示符格式。

\t时间
\u用户
```
$ PS1="[\t][\u]\$"
[15:09:31][xiang]$echo $PS1
[\t][\u]$

```

# L11 执行脚本
* 如果在新进程中运行shell脚本，一般使用 bash test.sh ；
* 如果在当前进程一般使用 `. ./test.sh` 这种写法，即 `source ./test.sh`。

```
#!/bin/bash

echo "What is the url of the shell tutorial?"
read URL
echo "$URL is very fast!"
echo $$
``` 