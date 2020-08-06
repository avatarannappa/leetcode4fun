-- 627. 交换工资，2020/8/6
update salary set sex = char(ascii('m') + ascii('f') - ascii(sex));