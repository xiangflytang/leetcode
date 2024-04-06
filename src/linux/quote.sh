#!/bin/bash
abc=hell0
echo 'single quote ${abc}'
echo "ouble quote ${abc}"

#只读变量
myUrl="http://c.biancheng.net/shell/"
#readonly myUrl
#myUrl="http://c.biancheng.net/shell/"

#myUrl="http://c.biancheng.net/shell/"
unset myUrl
echo $myUrl
