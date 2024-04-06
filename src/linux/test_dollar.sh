#!/bin/bash
echo " script name $0" 
function main {
	echo "$# variable"
	echo "they are $@"
	echo " $1"
	echo " $2"
	echo "process id $$"
}
main "$@"

echo "exit status"$?
