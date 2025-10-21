# Write your MySQL query statement below
with temp as (
      select requester_id as id  from RequestAccepted
          union all
              select accepter_id as id from RequestAccepted
              )
              select id,count(id) as num from temp
              group by id
              order by num desc limit 1;
