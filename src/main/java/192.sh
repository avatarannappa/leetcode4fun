# 192. 统计词频 2020/10/3
awk '{for(i=1;i<=NF;i++){a[$i]++;}};END{for(w in a){print w,a[w];}}' words.txt | sort -rn -k2