<#if curve_background_color??>
	<#if curve_background_color.data != "none">
		<#assign fill_value = curve_background_color.data />
	<#else>
		<#assign fill_value = "none" />
	</#if>
</#if>

<#if curve_border_color??>
	<#if curve_border_color.data != "none">
		<#assign stroke_value = curve_border_color.data />
	<#else>
		<#assign stroke_value = "none" />
	</#if>
</#if>

<#if curve_position.data?string == '["top"]'>
	<svg class="top-curve" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 96"><title>top curve</title><path d="M1440 96V54.35C1061.41-26.22 518.58 34.78 0 73.81V96z" fill="${fill_value}" stroke="${stroke_value}" /></svg>

	<style>
		.top-curve {
			margin-bottom: -8px;
		}
		
		.ie .top-curve {
			margin-bottom: -45px;
		}
		
		@media screen and (min-width: 1139px) {
    	    .ie .top-curve {
			    margin-bottom: -35px;
		    }
		}
	</style>
<#else>
	<svg class="bottom-curve" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 96"><title>bottom curve</title><path d="M1440 0v19.14C458.73 152.68 0 31.64 0 31.64V0z" fill="${fill_value}" stroke="${stroke_value}" /></svg>

	<style>
		.bottom-curve {
			margin-top: -7px;
		}
		
		.ie .bottom-curve {
			margin-top: -43px;
		}
		
		@media screen and (min-width: 1139px) {
    	    .ie .bottom-curve {
			    margin-bottom: -33px;
		    }
		}
	</style>
</#if>