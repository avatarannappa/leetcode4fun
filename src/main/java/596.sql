-- 596. 超过5名学生的课，2020/7/19
select class from courses group by class having count(distinct(student)) >= 5;