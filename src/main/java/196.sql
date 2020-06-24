-- 196. 删除重复的电子邮箱 2020/6/24
delete a from Person a, Person b where a.Email = b.Email and a.Id > b.Id;