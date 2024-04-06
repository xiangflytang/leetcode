#!/bin/bash

begin_time=`date +%s`
sleep 5s
finish_time=$(date +%s)
run_time=$((finish_time - begin_time))
echo "begin time: $begin_time"
echo "end time : $finish_time"
echo "run time: ${run_time}s"

#if out put has multiple line , it need double quote
#LSL=`ls -l`
#echo "$LSL"
