-- 620. 有趣的电影 easy
select * from cinema where mod(id, 2) = 1 and description != 'boring' order by rating DESC;