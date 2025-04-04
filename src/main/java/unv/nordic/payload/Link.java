package unv.nordic.payload;

import lombok.Builder;

@Builder
public record Link(String name, String url) {}
