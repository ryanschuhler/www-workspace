<div class="content-column countdown text-center">
	<#if event_info.early_bird_text.data?has_content>
		<p class="early-bird-info">${event_info.early_bird_text.data}</p>
	</#if>

	<div class="countdown-timer">&nbsp;</div>

	<div class="countdown-values">
		<div class="countdown-units">${countdown.day_text.data}</div>

		<div class="countdown-units">${countdown.hour_text.data}</div>

		<div class="countdown-units">${countdown.minute_text.data}</div>

		<div class="countdown-units">${countdown.seconds_text.data}</div>
	</div>

	<div class="block-container justify-center">
		<a class="btn btn-primary" href="${htmlUtil.escapeHREF(event_info.registration_link.data)}" target="_blank">
			${event_info.registration_button_text.data}
		</a>
	</div>
</div>

<style type="text/css">
	.countdown-timer {
		font-size: 3.5em;
		height: 1.25em;
	}

	.countdown-values {
		margin: 0 auto 40px;
		max-width: 260px;
	}

	.countdown-values .countdown-units {
		display: inline-block;
		font-size: 16px;
		width: 23.5%;
	}
</style>

<script>
	AUI().ready(
			'node',
			function(A) {
				function startCountdown(targetDate, node) {
					if (node && targetDate) {
						var _second = 1000;

						var _minute = _second * 60;

						var _hour = _minute * 60;

						var _day = _hour * 24;

						var timer;

						var showRemaining = function() {
							var now = new Date();

							var timeRemaining = targetDate - now;

							if (timeRemaining < 0) {
								clearInterval(timer);

								node.set('innerHTML', 'EXPIRED!');

								var countdownValues = A.one('.countdown-values');

								if (countdownValues) {
									countdownValues.hide();
								}

								return;
							}

							var days = Math.floor(timeRemaining / _day);
							var hours = Math.floor((timeRemaining % _day) / _hour);
							var minutes = Math.floor((timeRemaining % _hour) / _minute);
							var seconds = Math.floor((timeRemaining % _minute) / _second);

							var units = [days, hours, minutes, seconds];

							units.forEach(
								function(unit, index) {
									if (unit < 10) {
										unit = '0' + unit;

										units[index] = unit;
									}
								}
							);

							node.set('innerHTML', units[0] + ':' + units[1] + ':' + units[2] + ':' + units[3]);
						};

						timer = setInterval(showRemaining, 1000);
					}
				}

				var day = parseInt(${event_launch_time.day.data}, 10);
				var hour = parseInt(${event_launch_time.hour.data}, 10);
				var month = parseInt(${event_launch_time.month.data}, 10) - 1;
				var year = parseInt(${event_launch_time.year.data}, 10);

				// months start from 0 (Jan) to 11(Dec)

				var targetDate = new Date(Date.UTC(year, month, day, hour, 0, 0));

				startCountdown(targetDate, A.one('.countdown-timer'));
			}
	);
</script>