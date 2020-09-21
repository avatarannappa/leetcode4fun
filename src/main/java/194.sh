# 194. 转置文件 2020/9/21
awk '{for(i=1;i<=NF;i++){if(NR==1){a[i]=$i}else{a[i]=a[i]" "$i}}};END{for(i=1;i<=NF;i++){print a[i]}}' file.txt
