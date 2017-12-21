(function(u, c, a, m, o,l){o="script",l=document,a=l.createElement(o)
	,m=l.getElementsByTagName(o)[0],a.async=1,a.src=u,a.onload=c,
	m.parentNode.insertBefore(a,m)})('https://s3-eu-west-1.amazonaws.com/com-liferay-analytics/analytics-all-min.js', function() {

	Analytics.create({ analyticsKey: 'www-webteam.liferay.com' });
	Analytics.send('view', 'Layout');
});

console.log('Liferay analytics code loaded');