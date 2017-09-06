# GWT-CompletableFuture
GWT 2.8.0 compatible implementation of java.util.concurrent.CompletableFuture and supporting classes. The implementation is compatible with Java 8 lambdas.
(The preceding line was really included to help those looking for such via a seach engine)

This merely packages [this commit](https://github.com/nordligulv/gwt/commit/8b175153216b527e735a07feda4cb5d822caa7c8) by @nordligulv into a module consumable by GWT.

If/When GWT includes CompletableFuture emulation itself, this module will be obsolete.

## Usage

### Maven

Include the following in the `<dependencies>` section of your `pom.xml` file.

```
<dependency>
    <groupId>com.ekotrope.gwt</groupId>
    <artifactId>gwt-completablefuture</artifactId>
    <version>TODO</version>
</dependency>
```

### GWT

Include the following in your `*.gwt.xml` GWT module descriptor file.

`<inherits name='com.ekotrope.gwt.CompletableFuture'/>`

