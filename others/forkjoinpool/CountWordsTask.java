package forkjoinpool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CountWordsTask extends RecursiveTask<Long> {
  private final Path path;
  private final String word;

  public CountWordsTask(Path path, String word) {
    this.path = path;
    this.word = word;
  }

  @Override
  protected Long compute() {
    if (!Files.isDirectory(path)) {
      return WordCounter.countWordInFile(path, word);
    }
    Stream<Path> subpaths;
    try {
      subpaths = Files.list(path);
    } catch (IOException e) {
      return 0L;
    }
    List<CountWordsTask> subtasks =
        subpaths.map(path -> new CountWordsTask(path, word))
        .collect(Collectors.toList());
    invokeAll(subtasks);
    return subtasks
        .stream()
        .mapToLong(CountWordsTask::getRawResult)
        .sum();
  }
}
