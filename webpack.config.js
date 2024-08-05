const path = require('path');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const WarningsToErrorsPlugin = require("warnings-to-errors-webpack-plugin")

module.exports = (env, argv) => ({
    entry: {
        application: path.resolve(__dirname, './src/main/resources/static/javascript/application.js'),
    },
    output: {
        path: path.resolve(__dirname, './target/classes/static'),
        filename: 'javascript/[name].js',
        clean: true
    },
    devtool: argv.mode === 'production' ? false : 'eval-source-map',
    performance: {
        maxEntrypointSize: 488000,
        maxAssetSize: 488000
    },
    optimization: {
        minimize: true,
        minimizer: [
            (compiler) => {
                const TerserPlugin = require('terser-webpack-plugin');
                new TerserPlugin({
                    terserOptions: {
                        compress: {},
                    }
                }).apply(compiler);
            },
        ]
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: "css/application.css"
        }),
        new WarningsToErrorsPlugin()
    ],
    module: {
        rules: [
            {
                test: /\.js$'/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env'],
                    },
                },
            },
            {
                test: /\.css$/,
                exclude: /node_modules/,
                use: [
                    argv.mode === 'production' ? MiniCssExtractPlugin.loader : 'style-loader',
                    {
                        loader: 'css-loader',
                        options: {
                            importLoaders: 1,
                            sourceMap: true
                        }
                    },
                    {
                        loader: 'postcss-loader',
                        options: {
                            postcssOptions: {
                                plugins: [
                                    require('tailwindcss'),
                                    require('autoprefixer'),
                                ]
                            },
                            sourceMap: true
                        }
                    },
                    {
                        loader: 'sass-loader',
                        options: { sourceMap: true }
                    }
                ]
            }
        ]
    },
    resolve: {
        modules: [
            path.resolve(__dirname, './src/main/resources/static'),
            'node_modules'
        ],
    },
    devServer: {
        port: 8081,
        compress: true,
        open: true,
        static: {
            directory: path.resolve(__dirname, './target/classes/templates'),
        },
        watchFiles: [
            './target/classes/templates/**/*.html',
            './target/classes/static/javascript/**/*.js',
            './target/classes/static/css/**/*.css'
        ],
        proxy: [
            {
                context: '**',
                target: 'http://localhost:8080',
                secure: false,
                prependPath: false,
                headers: {
                    'X-Devserver': '1',
                }
            }
        ]
    }
});