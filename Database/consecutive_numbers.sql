/*
Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.
 */

# naive solution
select distinct(l1.Num)
from Logs l1, Logs l2, Logs l3
where l1.Id = l2.Id + 1 and l1.Num = l2.Num
and l2.Id = l3.Id + 1 and l2.Num = l3.Num


select distinct(l1.Num)
from Logs l1, Logs l2, Logs l3
where l1.Id + 1 = l2.Id and l1.Num = l2.Num
and l2.Id + 1 = l3.Id and l2.Num = l3.Num

# user-defined solution
# reference: http://www.madcoder.cn/leetcode-consecutive-numbers.html
SELECT DISTINCT Num FROM (
    SELECT Num, IF(Num = @last, @row := @row + 1, @row := 1) as times, @last := Num
    FROM Logs, (SELECT @last := 'x', @row := 0) r
) t
WHERE times >= 3;