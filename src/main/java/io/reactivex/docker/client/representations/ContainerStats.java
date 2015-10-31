/*
 * The MIT License
 *
 * Copyright 2015 Shekhar Gulati <shekhargulati84@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.reactivex.docker.client.representations;

import com.google.gson.annotations.SerializedName;

public class ContainerStats {
    @SerializedName("read")
    private String read;
    @SerializedName("network")
    private NetworkStats network;
    @SerializedName("memory_stats")
    private MemoryStats memoryStats;
    @SerializedName("cpu_stats")
    private CpuStats cpuStats;
    @SerializedName("precpu_stats")
    private CpuStats precpuStats;

    public String read() {
        return read;
    }

    public NetworkStats network() {
        return network;
    }

    public MemoryStats memoryStats() {
        return memoryStats;
    }

    public CpuStats cpuStats() {
        return cpuStats;
    }

    public CpuStats precpuStats() {
        return precpuStats;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (cpuStats == null ? 0 : cpuStats.hashCode());
        result = prime * result + (memoryStats == null ? 0 : memoryStats.hashCode());
        result = prime * result + (network == null ? 0 : network.hashCode());
        result = prime * result + (precpuStats == null ? 0 : precpuStats.hashCode());
        result = prime * result + (read == null ? 0 : read.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ContainerStats other = (ContainerStats) obj;
        if (cpuStats == null) {
            if (other.cpuStats != null) {
                return false;
            }
        } else if (!cpuStats.equals(other.cpuStats)) {
            return false;
        }
        if (memoryStats == null) {
            if (other.memoryStats != null) {
                return false;
            }
        } else if (!memoryStats.equals(other.memoryStats)) {
            return false;
        }
        if (network == null) {
            if (other.network != null) {
                return false;
            }
        } else if (!network.equals(other.network)) {
            return false;
        }
        if (precpuStats == null) {
            if (other.precpuStats != null) {
                return false;
            }
        } else if (!precpuStats.equals(other.precpuStats)) {
            return false;
        }
        if (read == null) {
            if (other.read != null) {
                return false;
            }
        } else if (!read.equals(other.read)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContainerStats{" +
                "read='" + read + '\'' +
                ", network=" + network +
                ", memoryStats=" + memoryStats +
                ", cpuStats=" + cpuStats +
                ", precpuStats=" + precpuStats +
                '}';
    }
}