-- Query 2: Count leads by priority, including groups with zero leads
WITH priorities AS (
    SELECT 'HOT' AS priority, 1 AS sort_order
    UNION ALL
    SELECT 'WARM', 2
    UNION ALL
    SELECT 'COLD', 3
),
classified_leads AS (
    SELECT
        CASE
            WHEN score >= 80 THEN 'HOT'
            WHEN score >= 50 THEN 'WARM'
            ELSE 'COLD'
        END AS priority
    FROM leads
)
SELECT
    p.priority,
    COUNT(c.priority) AS total_leads
FROM priorities p
LEFT JOIN classified_leads c
    ON p.priority = c.priority
GROUP BY p.priority, p.sort_order
ORDER BY p.sort_order;