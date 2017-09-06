# GWT-CompletableFuture
GWT 2.8.0 compatible implementation of java.util.concurrent.CompletableFuture and supporting classes. The implementation is compatible with Java 8 lambdas.
(The preceding line was really included to help those looking for such via a seach engine)

This merely packages commit [nordligulv/gwt@8b17515](https://github.com/nordligulv/gwt/commit/8b175153216b527e735a07feda4cb5d822caa7c8) into a standalone library for GWT.

If/When GWT includes CompletableFuture emulation itself, this library will be obsolete.

## Usage

### Maven

Include the following in the `<dependencies>` section of your `pom.xml` file.

```xml
<dependency>
    <groupId>com.ekotrope</groupId>
    <artifactId>gwt-completablefuture</artifactId>
    <version>1.0.0</version>
</dependency>
```

### GWT

Include the following in your `*.gwt.xml` GWT module descriptor file.

```xml
<inherits name='com.ekotrope.gwt.CompletableFuture'/>
```

