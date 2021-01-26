# logback-gson-formatter

[![Build Status](https://github.com/gessnerfl/logback-gson-formatter/workflows/CI%2FCD/badge.svg)](https://github.com/gessnerfl/logback-gson-formatter/workflows/CI%2FCD/badge.svg)
[ ![Download](https://api.bintray.com/packages/gessnerfl/oss-de.gessnerfl/logback-gson-formatter/images/download.svg) ](https://bintray.com/gessnerfl/oss-de.gessnerfl/logback-gson-formatter/_latestVersion)

Logback JSON Formatter using Google GSON library

Alternative Logback JSON Formatter which can be used as a replacement for Logback JSON. 

Use this library if you cannot or do not want to use logbacks jackson extension (logback-ext-jackson (https://github.com/qos-ch/logback-contrib/wiki/Jackson) for JSON formatting (e.g. due to classpath conflicts, GSON is already in use and you don't want to add additional libraries to you classpath).

## Usage

### 1. Add dependencies
To use the formatter add the Logback JSON libraries (https://github.com/qos-ch/logback-contrib/wiki/JSON) to your classpath. Except for logback-ext-jackson add this library.

<table>
	<tr>
		<th>JAR</th>
		<th>Maven Dependency</th>
	</tr>
	<tr>
		<td><code>logback-ext-json-core-<em>version</em>.jar</code></td>
		<td>pulled automatically when logack-ext-json-classic is added</td>
	</tr>
	<tr>
		<td><code>logback-ext-json-classic-<em>version</em>.jar</code></td>
		<td><pre>
&lt;dependency&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;ch.qos.logback.extensions&lt;/groupId&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;logback-ext-json-classic&lt;/artifactId&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;version&lt;/version&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;scope&gt;runtime&lt;/scope&gt;
&lt;/dependency&gt;
		</pre></td>
	</tr> 
	<tr>
		<td><code>logback-gson-formatter-<em>version</em>.jar</code></td>
		<td><pre>
&lt;dependency&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;de.gessnerfl.logback&lt;/groupId&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;logback-gson-formatter&lt;/artifactId&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;version&lt;/version&gt;
&nbsp;&nbsp;&nbsp;&nbsp;&lt;scope&gt;runtime&lt;/scope&gt;
&lt;/dependency&gt;
		</pre></td>
	</tr>
	<tr>
		<td><code>gson-<em>version</em>.jar</code></td>
		<td>pulled automatically when logback-gson-formatter is added</td>
	</tr>
</table>

### 2. Configure Logback appender

```xml
<appender name="file" class="ch.qos.Logback.core.FileAppender">
  <file>my-log-file.json</file>
  <encoder class="ch.qos.Logback.core.encoder.LayoutWrappingEncoder">
  	<layout class="ch.qos.Logback.contrib.json.classic.JsonLayout">
    	<jsonFormatter class="de.gessnerfl.logback.gson.GsonFormatter"/>
    </layout>
  </encoder>
</appender>
```

or if you prefer pretty print

```xml
<appender name="file" class="ch.qos.Logback.core.FileAppender">
  <file>my-log-file.json</file>
  <encoder class="ch.qos.Logback.core.encoder.LayoutWrappingEncoder">
  	<layout class="ch.qos.Logback.contrib.json.classic.JsonLayout" appendLineSeparator="true">
    	<jsonFormatter class="de.gessnerfl.logback.gson.GsonFormatter" prettyPrint="true"/>
    </layout>
  </encoder>
</appender>
```