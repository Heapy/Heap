var gulp = require('gulp');
var concat = require('gulp-concat');

/**
 * Check js for violations.
 */
var jshint = require('gulp-jshint');
var stylish = require('jshint-stylish');
gulp.task('jshint', function() {
    return gulp.src(['./app/**/*.js'])
        .pipe(jshint())
        .pipe(jshint.reporter(stylish));
});

/**
 * Minify html, for faster downloading to clients.
 */
var minifyHTML = require('gulp-minify-html');
gulp.task('minify-html', function() {
    return gulp.src(['./app/**/*.html'])
        .pipe(minifyHTML())
        .pipe(gulp.dest('./dist'));
});

/**
 * Delete all debugging statements (console.log, debugger, etc). Concat all js files into one. Uglify result.
 */
var stripDebug = require('gulp-strip-debug');
var uglify = require('gulp-uglify');
gulp.task('minify-scripts', function() {
    return gulp.src(['./app/**/*.js'])
        .pipe(stripDebug())
        .pipe(concat('script.js'))
        .pipe(uglify())
        .pipe(gulp.dest('./dist/js/'));
});

/**
 * Copy libs.
 */
gulp.task('js-libs', function() {
    return gulp.src([
            "./libs/angular/angular.js",
            "./libs/angular/angular.min.js",
            "./libs/angular/angular.min.js.map"
        ])
        .pipe(gulp.dest('./dist/js/'));
});

/**
 * Concat styles, add prefixes to styles for supporting browser-specific styles. Minify CSS.
 */
var autoprefix = require('gulp-autoprefixer');
var minifyCSS = require('gulp-minify-css');
gulp.task('minify-styles', function(done) {
    return gulp.src(['./app/**/*.css'])
        .pipe(concat('styles.css'))
        .pipe(autoprefix('last 2 versions'))
        .pipe(minifyCSS())
        .pipe(gulp.dest('./dist/css/'));
});

/**
 * Show size of css and js in dist dir.
 */
var size = require('gulp-size');
gulp.task('size', function () {
    return gulp.src(['./dist/js/*.js', './dist/css/*.css'])
        .pipe(size({showFiles: true}));
});

/**
 * Cleaning dist dir before project building.
 */
var clean = require('gulp-clean');
gulp.task('clean-dist', function () {
    return gulp.src(['./dist/**'], {read:false})
        .pipe(clean());
});

/**
 * Task that gulp call by default, when you run "gulp" command
 */
var runSequence = require('run-sequence');
gulp.task('default', function(done) {
    runSequence(['jshint', 'clean-dist'], ['minify-html', 'minify-scripts', 'minify-styles', 'js-libs'], 'size', done);
});