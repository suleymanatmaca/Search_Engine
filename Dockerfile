FROM maven:3.9.5-eclipse-temurin-8

# Install tools.
RUN /bin/sh -c 'apt-get update -y'
RUN /bin/sh -c 'apt-get install -y wget unzip'

RUN apt-get update -y & apt-get install -y wget unzip
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get install -y tzdata

# Install Chrome
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN dpkg -i google-chrome-stable_current_amd64.deb; apt-get -fy install

# ChromeDriver
RUN wget -q -O /tmp/chromedriver-linux64.zip https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.71/linux64/chromedriver-linux64.zip \
	&& unzip /tmp/chromedriver-linux64.zip -d /opt \
	&& rm /tmp/chromedriver-linux64.zip \
	&& ln -s /opt/chromedriver-linux64/chromedriver /usr/bin/chromedriver

WORKDIR /apps/qa
RUN chmod -R 777 /apps/qa
##RUN cp /usr/local/bin/chromedriver /apps/qa/src/test/resources/driver/

##Copy source code and pom file.
COPY src /apps/qa/src
COPY pom.xml /apps/qa

ENTRYPOINT ["mvn"]