var webpack = require("webpack");

module.exports = {
    entry: "./main",
    resolve: {
        modulesDirectories: [
            "."
        ]
    },
    output: {
        publicPath: "js/",
        filename: "bundle.js",
        chunkFilename: "[chunkhash][id].bundle.js"
    },
    plugins: [
        new webpack.optimize.OccurenceOrderPlugin(),
        new webpack.optimize.UglifyJsPlugin()
    ],
    devtool: "source-map"
};


