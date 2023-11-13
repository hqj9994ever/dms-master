# 关于
整合SSM框架（SpringMVC + Spring + MyBatis）
## 修改
jdbc.properties 对应的数据库地址

##新增表
class_list 班级表
room 宿舍表

表示查询 今天之前的7天 每天的日期
SELECT
DATE_SUB( CURDATE( ), INTERVAL 7 DAY ) AS click_date UNION ALL
SELECT
DATE_SUB( CURDATE( ), INTERVAL 6 DAY ) AS click_date UNION ALL
SELECT
DATE_SUB( CURDATE( ), INTERVAL 5 DAY ) AS click_date UNION ALL
SELECT
DATE_SUB( CURDATE( ), INTERVAL 4 DAY ) AS click_date UNION ALL
SELECT
DATE_SUB( CURDATE( ), INTERVAL 3 DAY ) AS click_date UNION ALL
SELECT
DATE_SUB( CURDATE( ), INTERVAL 2 DAY ) AS click_date UNION ALL
SELECT
DATE_SUB( CURDATE( ), INTERVAL 1 DAY ) AS click_date


 <select id="findLastWeek" resultType="java.util.LinkedHashMap">
    SELECT
      a.click_date readTime,
      IFNULL(b.total,0) as electricityConsumption
    FROM
      (
        SELECT
          DATE_SUB( CURDATE( ), INTERVAL 7 DAY ) AS click_date UNION ALL
        SELECT
          DATE_SUB( CURDATE( ), INTERVAL 6 DAY ) AS click_date UNION ALL
        SELECT
          DATE_SUB( CURDATE( ), INTERVAL 5 DAY ) AS click_date UNION ALL
        SELECT
          DATE_SUB( CURDATE( ), INTERVAL 4 DAY ) AS click_date UNION ALL
        SELECT
          DATE_SUB( CURDATE( ), INTERVAL 3 DAY ) AS click_date UNION ALL
        SELECT
          DATE_SUB( CURDATE( ), INTERVAL 2 DAY ) AS click_date UNION ALL
        SELECT
          DATE_SUB( CURDATE( ), INTERVAL 1 DAY ) AS click_date
      ) a
        LEFT JOIN (
        SELECT
          DATE_FORMAT( `date`, '%Y-%m-%d' ) AS datetime,
          sum( remain ) AS total
        FROM
          elect_rate
        WHERE
          room_id = #{roomId}
        GROUP BY
          DATE_FORMAT( date, '%Y-%m-%d' )
      ) b ON a.click_date = b.datetime
    order by a.click_date
  </select>