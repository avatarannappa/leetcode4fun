-- 262. 行程和用户. hard
-- 2021/11/2
-- avg函数用法
select 
    Request_at as Day,
    round(avg(Status!='completed'), 2) as 'Cancellation Rate'
from 
    Trips 
where 
    Driver_id in (select Users_Id from Users where Banned = 'No') 
    and Client_id in (select Users_Id from Users where Banned = 'No') 
    and Request_at BETWEEN '2013-10-01' AND '2013-10-03'
group by 
    Request_at