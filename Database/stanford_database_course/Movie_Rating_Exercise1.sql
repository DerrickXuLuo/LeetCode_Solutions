/*https://courses.edx.org/courses/course-v1:StanfordOnline+SOE.YDB-SQL0001+2T2020/courseware/ch-sql/f431697049ef486280699ae07477dfda/?activate_block_id=block-v1%3AStanfordOnline%2BSOE.YDB-SQL0001%2B2T2020%2Btype%40sequential%2Bblock%40f431697049ef486280699ae07477dfda*/

/*
select title
from Movie
where director = 'Steven Spielberg';
*/

/*
select distinct year
from Movie, Rating
where Movie.mID = Rating.mID and stars >= 4
order by year;
*/

/*
select title 
from Movie
where mID not in (select mID from Rating);
*/

/*
select name 
from Reviewer, Rating
where Reviewer.rID = Rating.rID and Rating.ratingDate is null;
*/

#reviewer name, movie title, stars, and ratingDate
/*
select name, title, stars, ratingDate
from Movie, Reviewer, Rating
where Reviewer.rID = Rating.rID and Movie.mID = Rating.mID
order by name, title, stars;
*/

/*
select name, title
from Movie
inner join Rating R1 using(mID)
inner join Rating R2 using(rID)
inner join Reviewer using(rID)
where R1.mID = R2.mID and R1.ratingDate < R2.ratingDate and R1.stars < R2.stars;  
*/

/*
select title, max(stars)
from Movie, Rating
where Movie.mID = Rating.mID
group by title
order by title;
*/

/*
select title, (max(stars) - min(stars)) as rating_spread
from Movie, Rating
where Movie.mID = Rating.mID
group by title
order by rating_spread Desc, title;
*/

/*
select avg(before1980.avg) - avg(after1980.avg)
from (
	select avg(stars) as avg
    from Movie
    inner join Rating using(mID)
    where year < 1980
    group by mID
) as before1980, (
	select avg(stars) as avg
    from Movie
    inner join Rating using(mID)
    where year > 1980
    group by mID
) as after1980;
*/

