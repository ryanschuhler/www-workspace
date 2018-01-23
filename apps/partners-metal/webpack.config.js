const webpack = require('webpack');
var path = require('path');
const JS_DIR = path.resolve(
	__dirname,
	'src/main/resources/META-INF/resources/js'
);

module.exports = {
	entry: path.resolve(JS_DIR, 'src/index.js'),
	module: {
		rules: [
			{
				test: /\.js$/,
				exclude: /(node_modules)/,
				use: {
					loader: 'babel-loader',
					options: {
						compact: false,
						presets: ['babel-preset-metal-jsx']
					}
				}
			},
			{
				test: /\.scss$/,
				exclude: /(node_modules)/,
				use: [
					'style-loader',
					{
						loader: 'css-loader',
						query: {
							camelCase: true,
							localIdentName: '[name]_[local]__[hash:base64:5]',
							modules: true
						}
					},
					{
						loader: 'sass-loader'
					}
				]
			}
		]
	},
	output: {
		library: 'metal',
		libraryTarget: 'this',
		filename: 'bundle.js',
		path: path.resolve(JS_DIR, 'dist'),
		publicPath: '/'
	},
	plugins: [new webpack.optimize.ModuleConcatenationPlugin()]
};
