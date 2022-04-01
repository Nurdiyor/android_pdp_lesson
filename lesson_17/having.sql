select count(group_id) from student 
group by group_id
having count(group_id)>2