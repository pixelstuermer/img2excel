[![Build Status](https://travis-ci.org/pixelstuermer/img2excel.svg?branch=master)](https://travis-ci.org/pixelstuermer/img2excel)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![GitHub release](https://img.shields.io/github/release/pixelstuermer/img2excel.svg)](https://github.com/pixelstuermer/img2excel/releases)

![intro](https://raw.githubusercontent.com/pixelstuermer/img2excel/master/src/readme-content/intro.jpg)

[![forthebadge](http://forthebadge.com/images/badges/you-didnt-ask-for-this.svg)](http://forthebadge.com)

# img2excel :rocket:
Convert images into `.xlsx` files and create awesome Excel art without the usage of macros.

# Requirements
For running the command line tool with the terminal, simply [Java](https://java.com/download/) is required. When using the core module as a dependency within another project, the installation of [Lombok](https://projectlombok.org) might be necessary.

# QuickStart
1. Download the [latest release](https://github.com/pixelstuermer/img2excel/releases/latest) of the command line tool `img2excel-cli-{...}.jar`.
2. Run the following command from within your terminal: `java -jar /{path}/img2excel-cli-{...}.jar /{path}/{image}.jpg`.
3. Open the resulting `.xlsx` file after the converter has finished. It is at the same location as the input image file.

Here is a full command example for version `1.0.0` and the [sample file](https://raw.githubusercontent.com/pixelstuermer/img2excel/master/src/example/hamnoy_small.jpeg) `hamnoy_small.jpeg`. Therefore, we assume that both (jar and image) are located in the same folder. The Excel file will also be generated at this location. Also, the terminal is opened at the same folder:

    java -jar img2excel-cli-1.0.0.jar hamnoy_small.jpeg

The command can also be executed from within any other location, giving it the absolute path of the jar and of the image. The Excel file will then be stored at the location of the input image file:

    java -jar /some/path/img2excel-cli-1.0.0.jar /another/path/hamnoy_small.jpeg

# Usage CLI Tool
The command line tool can handle absolute and relative file paths, and can convert popular image file formats (such as `.jpg`, `.jpeg` or `.png`). It therefore needs the path of the input image file as the only argument:

    java -jar /path/img2excel-cli-{...}.jar /path/{...}.jpg

# Usage Java
To be done.

# Recommendations
It is recommended to use really small images. Images with the dimensions around `60*35` pixels are great (yes, this is really small and will take about 4 minutes). Although the application scales bigger images down, it is best practice to scale them down before manually. Excel can only handle a limited amount of cell styles which is why images cannot be converted with their original size.