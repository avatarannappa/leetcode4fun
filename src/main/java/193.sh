# 193. 有效电话号码,2020/6/27
# 你可以假设一个有效的电话号码必须满足以下两种格式： (xxx) xxx-xxxx 或 xxx-xxx-xxxx。（x 表示一个数字）

grep -P '^(\(\d{3}\) |\d{3}-)\d{3}-\d{4}$' file.txt
grep -P '^([(]\d{3}[)] |\d{3}-)\d{3}-\d{4}$' file.txt
grep -E '^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$' file.txt