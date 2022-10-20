-- 178. 分数排名
select
a.Score,
(select count(distinct b.Score) + 1 from Scores b where b.Score > a.Score) as Rank
from Scores a order by Score DESC;