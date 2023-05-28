package generic.repository.file;

public interface FileRepository<T> {
    void createFile();

    String slice(int startLineNumber, int endLineNumber);

    void minifyFile();

    void delete();
}
