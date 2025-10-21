# Write your MySQL query statement below
WITH temp AS (
      SELECT 
              visited_on,
                      SUM(amount) OVER (ORDER BY visited_on ROWS 6 PRECEDING) AS amount,
                              RANK() OVER (ORDER BY visited_on) AS rk
                                  FROM (
                                          SELECT visited_on, SUM(amount) AS amount
                                                  FROM Customer
                                                          GROUP BY visited_on
                                                              ) t
                                                              )
                                                              SELECT 
                                                                  visited_on,
                                                                      amount,
                                                                          ROUND(amount / 7, 2) AS average_amount
                                                                          FROM temp
                                                                          WHERE rk > 6;
