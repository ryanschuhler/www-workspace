import Flexbox from '../../atoms/Flexbox/';
import Dropdown from '../../atoms/Dropdown/';
import SearchInput from '../../atoms/SearchInput/';
import JSXComponent from 'metal-jsx';

class FilterBar extends JSXComponent {
	onPartnerLevelChange(e) {
		this.state.partnerLevelFilter = e.target.value;
		this.props.onFilterChange(this.state);
	}

	onRegionChange(e) {
		this.state.regionFilter = e.target.value;
		this.props.onFilterChange(this.state);
	}

	onSearchChange(e) {
		this.state.searchFilter = e.target.value;
		this.props.onFilterChange(this.state);
	}

	resetFilters() {
		this.state.partnerLevelFilter = null;
		this.state.regionFilter = null;
		this.state.searchFilter = null;
		this.props.onFilterChange(this.state);
	}

	render() {
		return (
			<div>
				<Flexbox
					flexWrap="wrap"
					justifyContent="space-between"
					width="100%"
				>
					<Flexbox justifyContent="flex-start">
						<Dropdown
							options={this.props.partnerLevels}
							disableFirst={false}
							selectText="Partner Levels"
							onChangeHandler={this.onPartnerLevelChange.bind(
								this
							)}
							value={this.state.partnerLevelFilter}
						/>

						<Dropdown
							options={this.props.regions}
							disableFirst={false}
							selectText="Regions"
							onChangeHandler={this.onRegionChange.bind(this)}
							value={this.state.regionFilter}
						/>
						<button onClick={this.resetFilters.bind(this)}>
							Reset
						</button>
					</Flexbox>

					<SearchInput
						onKeyUp={this.onSearchChange.bind(this)}
						placeholder="Search Partners"
					/>
				</Flexbox>
				partnerLevel: {this.state.partnerLevelFilter}
				region: {this.state.regionFilter}
			</div>
		);
	}
}

FilterBar.STATE = {
	partnerLevelFilter: {
		value: ''
	},
	regionFilter: {
		value: ''
	},
	searchFilter: {
		value: ''
	}
};

export default FilterBar;
