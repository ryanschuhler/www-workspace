AUI.add(
	'osb-form',
	function(A) {
		var OSBForm = A.Component.create(
			{
				ATTRS: {
					customRules: {
						value: {}
					},

					fieldClassName: {
						value: 'field-wrapper'
					},

					fieldStrings: {
						value: {}
					},

					formId: {
						value: '#osbForm'
					},

					rules: {
						value: {}
					}
				},

				NAME: 'osb-form',

				RULES: {
					conditionallyRequired: function(val, node, ruleValue) {
						var instance = this;

						var field = instance.getField(ruleValue.fieldname);

						if (field && ruleValue.values.indexOf(field.val()) >= 0) {
							return A.config.FormValidator.RULES.hasValue(val, node, ruleValue);
						}

						return true;
					}
				},

				prototype: {
					bindUI: function() {
						var instance = this;

						A.bind(instance.syncUI, instance);
					},

					syncUI: function() {
						var instance = this;

						var form = A.one(instance.get('formId'));

						instance._initializeValidator(form);

						instance._delegateFieldFocused(form);
						instance._delegateFieldCheck(form);
					},

					hasErrors: function() {
						var instance = this;

						return instance._formValidator.hasErrors();
					},

					validatable: function(field) {
						var instance = this;

						var fieldRules = instance.get('rules')[field.get('name')];
						var validatable = false;

						if (fieldRules) {
							validatable = instance.normalizeRuleValue(fieldRules.required, field) ||
								instance.normalizeRuleValue(fieldRules.conditionallyRequired, field) ||
								A.config.FormValidator.RULES.hasValue.apply(instance, [field.val(), field]);
						}

						return !!validatable;
					},

					validate: function() {
						var instance = this;

						instance._formValidator.validate();
					},

					_addCustomRules: function(customRules) {
						var instance = this;

						if (A.Object.isEmpty(customRules)) {
							return;
						}

						var rules = {};
						var strings = {};

						A.each(
							customRules,
							function(rule, ruleName) {
								rules[ruleName] = rule;
								strings[ruleName] = A.config.FormValidator.STRINGS.DEFAULT;
							}
						);

						A.mix(A.config.FormValidator.RULES, rules, true);
						A.mix(A.config.FormValidator.STRINGS, strings, true);
					},

					_delegateFieldCheck: function(form) {
						var instance = this;

						form.delegate(
							'change',
							function(event) {
								var node = event.currentTarget;

								instance._fieldCheck(node);
							},
							'.' + instance.get('fieldClassName')
						);
					},

					_delegateFieldFocused: function(form) {
						var instance = this;

						form.delegate(
							'focus',
							function() {
								this.addClass('field-focused');
							},
							'.' + instance.get('fieldClassName')
						);

						form.delegate(
							'blur',
							function() {
								this.removeClass('field-focused');
							},
							'.' + instance.get('fieldClassName')
						);
					},

					_fieldCheck: function(node) {
						var input = node.one('.field');

						if (!input) {
							input = node.one('select');
						}

						if (!input) {
							input = node.one('input');
						}

						if (input.get('type') === 'checkbox' && input.get('checked') === false) {
							node.removeClass('field-filled');
						}
						else if (input.get('value')) {
							node.addClass('field-filled');
						}
						else {
							node.removeClass('field-filled');
						}
					},

					_initializeValidator: function(form) {
						var instance = this;

						A.mix(A.config.FormValidator.RULES, OSBForm.RULES, true);

						instance._addCustomRules(instance.get('customRules'));

						instance._formValidator = new A.FormValidator(
							{
								boundingBox: instance.get('formId'),
								fieldContainer: '.' + instance.get('fieldClassName'),
								fieldStrings: instance.get('fieldStrings'),
								rules: instance.get('rules'),
								validateOnBlur: true
							}
						);

						instance._formValidator.validatable = instance.validatable;
					}
				}
			}
		);

		A.OSBForm = OSBForm;
	},
	'2.0',
	{
		requires: ['aui-base', 'aui-form-validator']
	}
);