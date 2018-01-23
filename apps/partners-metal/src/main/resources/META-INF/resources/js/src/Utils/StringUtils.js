var utils = {
	fuzzy(str, pattern) {
		pattern = pattern.split('').reduce(function(a, b) {
			return a + '.*' + b;
		});

		return new RegExp(pattern).test(str);
	}
};

export default utils;
