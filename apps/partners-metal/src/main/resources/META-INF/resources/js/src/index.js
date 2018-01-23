'use strict';

import JSXComponent from 'metal-jsx';
// import { Dropdown } from 'osb-www-components';

// data
import examplePartners from './sampleData/partners';
import examplePartnerLevels from './sampleData/partnerLevels';
import exampleRegions from './sampleData/regions';

// utils
import StringUtils from './Utils/StringUtils';

// components
import FilterBar from './components/organisms/FilterBar';
import PartnersDisplay from './components/organisms/PartnersDisplay/';

class PartnersApp extends JSXComponent {
	handleFilterChange(state) {
		this.state.partners = examplePartners;
		this.state.filters = state;
		this.filterPartners();
	}

	filterPartners() {
		this.state.partners = this.state.partners.filter(partner => {
			return (
				partner.partnerships[0]['level']
					.toLowerCase()
					.includes(
						this.state.filters.partnerLevelFilter.toLowerCase()
					) &&
				partner.partnerships[0]['countryName']
					.toLowerCase()
					.includes(this.state.filters.regionFilter.toLowerCase()) &&
				StringUtils.fuzzy(partner.name, this.state.filters.searchFilter)
			);
		});
	}

	render() {
		return (
			<div class="partners-app">
				<FilterBar
					partnerLevels={examplePartnerLevels}
					regions={exampleRegions}
					onFilterChange={this.handleFilterChange.bind(this)}
				/>
				<PartnersDisplay regionPartners={this.state.partners} />
			</div>
		);
	}
}

PartnersApp.STATE = {
	partners: {
		value: examplePartners
	},
	filters: {
		value: null
	}
};

export { PartnersApp };
export default PartnersApp;
