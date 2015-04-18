

def length_of_longest_substring(s)
    last_positions = {}

    sindex = 0
    cindex = 0
    longest_len = 0
    while cindex <= s.length do
        if !last_positions[s[cindex]].nil? && last_positions[s[cindex]] >= sindex
            longest_len = [longest_len, cindex - sindex].max
            sindex = last_positions[s[cindex]] + 1
        end
        last_positions[s[cindex]] = cindex
        cindex += 1
    end
    [longest_len, s.length - sindex].max # MARK: easy to forget
end

puts length_of_longest_substring('abcabcbb')