package generic.repository.file;

import generic.repository.Repository;
import generic.repository.InvalidIndexOrLineException;
import generic.shared.Base;

import java.io.*;
import java.util.Objects;

public class GenericFileRepository<T extends Base> implements Repository<T>, FileRepository<T> {
    private final File file;

    public GenericFileRepository(String directory) {
        file = new File(directory);
    }

    @Override
    public void createFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file creating%s", e));
        }
    }

    @Override
    public void add(T item) {
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.append(item + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file writing%s", e));
        }
    }

    @Override
    public void add(T[] items) {
        for (T item : items) {
            add(item);
        }
    }

    @Override
    public T get(int lineNumber) {
        int line = 1;
        String currentLine;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (lineNumber == line) {
                    break;
                }
                line++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file getting line%s", e));
        }
        return (T) Base.convert(currentLine);
    }

    @Override
    public String slice(int startLineNumber, int endLineNumber) {
        int line = 1;
        StringBuilder stringBuilder = new StringBuilder();
        String currentLine;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (line >= startLineNumber && line <= endLineNumber) {
                    stringBuilder.append(currentLine + '\n');
                }
                line++;
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file slicing%s", e));
        }
    }

    @Override
    public void minifyFile() {
        String currentLine;
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(currentLine.trim());
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuilder + "");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file fining item%s", e));
        }
    }

    @Override
    public int find(T item) {
        int lineNumber = 1;
        String currentLine;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                for (String line : currentLine.split(" ")) {
                    if (line.equals(item)) {
                        return lineNumber;
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file fining item%s", e));
        }

        return -1;
    }

    @Override
    public void shift(int lineNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        String currentLine;
        int line = 0;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                line++;
                if (lineNumber == line) continue;
                stringBuilder.append(currentLine + "\n");
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuilder + "");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file shifting item%s", e));
        } finally {
            System.out.println(stringBuilder);
        }
    }

    @Override
    public void remove(int lineNumber) throws InvalidIndexOrLineException {
        if (lineNumber < 1) {
            throw new InvalidIndexOrLineException(String.format("Invalid line number%d", lineNumber));
        }
        shift(lineNumber);
    }

    @Override
    public void remove(T item) throws InvalidIndexOrLineException {
        int line = find(item);
        if (line == -1) {
            throw new InvalidIndexOrLineException(String.format("Invalid line number%d", line));
        }
        remove(line);
    }

    @Override
    public void removeDuplicates(T item) throws InvalidIndexOrLineException {
        StringBuilder stringBuilder = new StringBuilder();
        String currentLine;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                Base check = Base.convert(currentLine);
                if (item != null && check != null && Objects.equals(item.getId(), check.getId())) {
                    stringBuilder.append("");
                    continue;
                }
                stringBuilder.append(currentLine);
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuilder + "");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file removing duplicates item%s", e));
        } finally {
            System.out.println(stringBuilder);
        }
    }


    @Override
    public void update(int lineNumber, T item) throws InvalidIndexOrLineException {
        StringBuilder stringBuilder = new StringBuilder();
        String currentLine;
        int line = 0;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                line++;
                if (lineNumber == line) {
                    stringBuilder.append(item + "\n");
                } else {
                    stringBuilder.append(currentLine + "\n");
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuilder + "");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in file updating item%s", e));
        } finally {
            System.out.println(stringBuilder);
        }
    }

    @Override
    public boolean contain(T item) {
        int line = find(item);
        return line != -1;
    }

    @Override
    public void clear() {
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Exception in file clearing", e);
        }
    }

    @Override
    public void print() {
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Exception in file printing", e);
        } finally {
            System.out.println(stringBuilder);
        }
    }

    @Override
    public void delete() {
        file.delete();
    }
}
