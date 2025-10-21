# Write your MySQL query statement below
SELECT u.name AS results
FROM Users AS u
WHERE u.user_id = (
    SELECT mr.user_id
        FROM MovieRating AS mr
            JOIN Users AS u2 ON mr.user_id = u2.user_id
                GROUP BY mr.user_id
                    ORDER BY COUNT(*) DESC, u2.name ASC
                        LIMIT 1
                        )
                        UNION ALL
                        SELECT m.title AS results
                        FROM Movies AS m
                        WHERE m.movie_id = (
                            SELECT mr.movie_id
                                FROM MovieRating AS mr
                                    JOIN Movies AS m2 ON mr.movie_id = m2.movie_id
                                        WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
                                            GROUP BY mr.movie_id
                                                ORDER BY AVG(mr.rating) DESC, m2.title ASC
                                                    LIMIT 1
                                                    );