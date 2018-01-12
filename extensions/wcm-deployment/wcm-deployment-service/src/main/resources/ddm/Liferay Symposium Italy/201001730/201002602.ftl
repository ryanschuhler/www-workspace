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

<div class="content-column countdown text-center">
	<#if event_info.early_bird_text.data?has_content>
		<p>${event_info.early_bird_text.data}</p>
	</#if>
	
	<div class="countdown-timer">
		&nbsp;
	</div>

	<div class="countdown-values">
		<div class="countdown-units">D</div>
		<div class="countdown-units">H</div>
		<div class="countdown-units">M</div>
		<div class="countdown-units">S</div>
	</div>

	<div class="block-container justify-center">
		<a class="btn btn-primary" target="_blank" href="${event_info.registration_link.data}">
			Garantisciti oggi il tuo posto
		</a>
	</div>
</div>

<script>
	AUI().ready(
		'node',
		function(A) {
			function startCountdown(year, month, day, hour, minute, second, selector) {
				var end = new Date(Date.UTC(year, month, day, hour, minute, second));

				var _second = 1000;
				var _minute = _second * 60;
				var _hour = _minute * 60;
				var _day = _hour * 24;
				var timer;

				function showRemaining() {
					var selectedNode = A.one(selector);
					
					var now = new Date();

					var distance = end - now;

					if (distance < 0) {
						clearInterval(timer);

						var earlyBirdButton = A.one('#earlyBirdButton');
						var countdownValues = A.one('.countdown-values');

						if (selectedNode) {
							selectedNode.set('innerHTML', 'EXPIRED!');
						}

						if (earlyBirdButton) {
							earlyBirdButton.hide();
						}

						if (countdownValues) {
							countdownValues.hide();
						}

						return;
					}

					var days = Math.floor(distance / _day);
					var hours = Math.floor((distance % _day) / _hour);
					var minutes = Math.floor((distance % _hour) / _minute);
					var seconds = Math.floor((distance % _minute) / _second);

					var units = [days, hours, minutes, seconds];
					var count = 0;

					units.forEach(
						function(unit) {
							if (unit < 10) {
								unit = '0' + unit;
								units[count] = unit;
							}

							count++;
						}
					);

					if (selectedNode) {
						selectedNode.set('innerHTML', units[0] + ':' + units[1] + ':' + units[2] + ':' + units[3]);
					}
				}

				timer = setInterval(showRemaining, 1000);
			}

			var year = parseInt(${event_launch_time.year.data});
			var month = parseInt(${event_launch_time.month.data}) - 1;
			var day = parseInt(${event_launch_time.day.data});
			var hour = parseInt(${event_launch_time.hour.data});

			//months start from 0 (Jan) to 11(Dec)
			startCountdown(year, month, day, hour, 0, 0, '.countdown-timer');
		}
	);
</script>