# 显示inode信息
ls -i

# sed 用法
https://c.biancheng.net/view/4028.html
https://billie66.github.io/TLCL/book/chap21.html

# cat 用法
cat -A 查看隐藏字符
[me@linuxbox ~]$ cat -A foo.txt
^IThe quick brown fox jumped over the lazy dog.       $
^I 是Tab键
$ 是结束符。 
cat -ns （-n）查看行号， s 多个空白行只显示一行。


# sed 命令
打印1,5
sed -n '1,5p' distros.txt
打印（highlight）
sed -n '/sushi/p' distros.txt
直接修改
sed -i 's/SUSE/sushi/p' distros.txt